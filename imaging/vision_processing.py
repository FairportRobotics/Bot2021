import sys
import math
import cv2
import numpy as np
from networktables import NetworkTablesInstance as nti
from cscore import CameraServer, VideoSource, CvSource, VideoMode, CvSink, UsbCamera
import logging as log

# This code is designed to work for the Microsoft Lifecam HD3000 and the limelight ring

log.basicConfig(level = log.DEBUG)

# NetworkTables set up
ntinst = nti.getDefault()
ntinst.startClientTeam(578)

sd = ntinst.getTable('SmartDashboard')

# Start the camera
cs = CameraServer.getInstance()
cs.enableLogging()
Camera = UsbCamera('rPi Camera 0', 0)
Camera.setResolution(1280, 720)
cs.addCamera(Camera)

CvSink = cs.getVideo()
outputStream = cs.putVideo("Processed Frames", 1280, 720)

img = np.zeros(shape=(1280, 720, 3), dtype=np.uint8)

#cap = cv2.VideoCapture(2)

while(True):

    GotFrame, img = CvSink.grabFrame(img)
    if (GotFrame == 0):
        outputStream.notifyError(CvSink.getError())
        continue

#    ret, img = cap.read()

    # Filter the limelight
    blur = cv2.blur(img, (5, 5))
    b, g, r = cv2.split(img)
    thresh = cv2.threshold(g, 250, 255, cv2.THRESH_TOZERO)[1]
#    mask = cv2.bitwise_and(blur, blur, thresh)
    norm = cv2.normalize(thresh, None, 0, 255, cv2.NORM_MINMAX)
#    temp = cv2.cvtColor(norm, cv2.COLOR_BGR2HSV)
#    hsv = cv2.inRange(temp, (0, 0, 222),  (180, 255, 255))
    erode = cv2.erode(norm, None, cv2.BORDER_CONSTANT, iterations=1)
    dilate = cv2.dilate(erode, None, cv2.BORDER_CONSTANT, iterations=1)
    _, contours, hierarchy = cv2.findContours(dilate, cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)
#    contours, hierarchy = cv2.findContours(dilate, cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)

    if len(contours) > 0:

        contours = sorted(contours, key = cv2.contourArea, reverse = True)
        rawHull = cv2.convexHull(contours[0])
        area = cv2.contourArea(rawHull)
#        area = cv2.contourArea(rawHull)

#        for c in contours:
#            tempHull = cv2.convexHull(c)
#            if area <= cv2.contourArea(tempHull):
#                area = cv2.contourArea(tempHull)
#                rawHull = tempHull

        print('--------------------------------------')

#        epsilon = 0.05 * cv2.arcLength(rawHull, True) # Adjust the constant to change accuracy (lower = higher accuracy)
#        approx = cv2.approxPolyDP(rawHull, epsilon, True) # Approximate the contour to a shape
        out = cv2.drawContours(img, [rawHull], 0, (255,0,0), 3)

        topmost = tuple(rawHull[rawHull[:,:,1].argmin()][0])[1] # Lowest y value on contour
        bottommost = tuple(rawHull[rawHull[:,:,1].argmax()][0])[1] # Greatest y value on contour
        height = bottommost - topmost
        print('Height: ', height)
        a = .00003
        b = -0.0175
        c = 4.691
        d = -624.04
        e = 41215
        f = -1000000
        rpm = (a*(height**5))+(b*(height**4)) + (c*(height**3)) + (d*(height**2)) + (e*height) + f
        print('RPM: ', rpm)

        # Centroid
        moments = cv2.moments(rawHull)
        if moments['m00'] == 0: continue
        cx = int(moments['m10'] / moments['m00'])
        print('Center X: ', cx)

        print('Area: ', area)

        # NetworkTables time! Yay! ...
        sd.putNumber("center-x", cx)
        sd.putNumber("rpm", rpm)
        sd.putNumber("height", height)
        sd.putNumber("area", area)

        print()
        outputStream.putFrame(out)

#        cv2.imshow('Camera Feed', out)

    if cv2.waitKey(1) & 0xFF == ord('q'):
        break

cap.release()
cv2.destroyAllWindows()
