#File: LambdaAreas.py
#William Smolinski

import math

TriangleArea = lambda base, height: 0.5 * (base * height)

SquareArea = lambda side: side ** 2

RectangleArea = lambda length, width: length * width

CircleArea = lambda radius: math.pi * radius ** 2

RhombusArea = lambda diagonal1, diagonal2: (diagonal1 * diagonal2) / 2

TrapezoidArea = lambda smallBase, largeBase, height:(
    ((smallBase + largeBase) / 2) * height)
