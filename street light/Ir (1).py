import RPi.GPIO as GPIO
class Ir:
    GPIO.setwarnings(False)
    GPIO.setmode(GPIO.BOARD)
    def getIrStatus(self):
        GPIO.setup(8,GPIO.IN)
        if GPIO.input(8) == 1:
            return 'No'
        else:
            return 'Yes'
        
