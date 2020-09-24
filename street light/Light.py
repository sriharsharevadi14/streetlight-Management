import RPi.GPIO as GPIO
class Light:
    GPIO.setwarnings(False)
    GPIO.setmode(GPIO.BOARD)
    def getLightStatus(self):
        GPIO.setup(3,GPIO.IN)
        if GPIO.input(3) == 1:
            return 'Night'
        else:
            return 'Day'
        