import RPi.GPIO as GPIO
class LED:
    GPIO.setwarnings(False)
    GPIO.setmode(GPIO.BOARD)
    def onLed(self,a):
        if a==1:
            GPIO.setup(10,GPIO.OUT)
            GPIO.output(10,GPIO.HIGH)
        elif a==2:
            GPIO.setup(12,GPIO.OUT)
            GPIO.output(12,GPIO.HIGH)
        elif a==3:
            GPIO.setup(16,GPIO.OUT)
            GPIO.output(16,GPIO.HIGH)
        elif a==4:
            GPIO.setup(18,GPIO.OUT)
            GPIO.output(18,GPIO.HIGH)
        elif a==5:
            GPIO.setup(22,GPIO.OUT)
            GPIO.output(22,GPIO.HIGH)
    def offLed(self,a):
        if a==1:
            GPIO.setup(10,GPIO.OUT)
            GPIO.output(10,GPIO.LOW)
        elif a==2:
            GPIO.setup(12,GPIO.OUT)
            GPIO.output(12,GPIO.LOW)
        elif a==3:
            GPIO.setup(16,GPIO.OUT)
            GPIO.output(16,GPIO.LOW)
        elif a==4:
            GPIO.setup(18,GPIO.OUT)
            GPIO.output(18,GPIO.LOW)
        elif a==5:
            GPIO.setup(22,GPIO.OUT)
            GPIO.output(22,GPIO.LOW)
    def onAllLed(self):
        
        GPIO.setup(10,GPIO.OUT)
        GPIO.output(10,GPIO.HIGH)
  
        GPIO.setup(12,GPIO.OUT)
        GPIO.output(12,GPIO.HIGH)
   
        GPIO.setup(16,GPIO.OUT)
        GPIO.output(16,GPIO.HIGH)
  
        GPIO.setup(18,GPIO.OUT)
        GPIO.output(18,GPIO.HIGH)
   
        GPIO.setup(22,GPIO.OUT)
        GPIO.output(22,GPIO.HIGH)
        
    def offAllLed(self):
        
        GPIO.setup(10,GPIO.OUT)
        GPIO.output(10,GPIO.LOW)
  
        GPIO.setup(12,GPIO.OUT)
        GPIO.output(12,GPIO.LOW)
   
        GPIO.setup(16,GPIO.OUT)
        GPIO.output(16,GPIO.LOW)
  
        GPIO.setup(18,GPIO.OUT)
        GPIO.output(18,GPIO.LOW)
   
        GPIO.setup(22,GPIO.OUT)
        GPIO.output(22,GPIO.LOW)
