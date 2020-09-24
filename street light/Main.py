import RPi.GPIO as GPIO
import time
from LED import *
from Light import *
from Ir import *
from Rest import *
from TextLocal import *
import datetime
rest = Rest()
GPIO.setwarnings(False)
GPIO.setmode(GPIO.BOARD)
GPIO.setup(31,GPIO.IN)
GPIO.setup(33,GPIO.IN)
GPIO.setup(35,GPIO.IN)
GPIO.setup(37,GPIO.IN)
lcd=LED()
light = Light()
ir = Ir()
mode = 'auto'
count = 0
textLocal = TextLocal()
while True:
    mymode = rest.get('SmartStreet/Mode')
    mode = mymode[1]['mode']
    print(mode)
    time.sleep(1)
    try:
        if mode == 'auto':
            
            if light.getLightStatus() == 'Night':
                d = 0
                if ir.getIrStatus() == 'Yes':
                    lcd.onAllLed()
                    count = 0;
                    if d==0:
                        textLocal.sendSMS('7892410891','Lights Switched On '+str(datetime.datetime.now()))
                    d = d+1
                else:
                    if count ==5:
                        lcd.offAllLed()
                        d=0
                    else:
                        count = count+1
            else:
                lcd.offAllLed()
        if mode == 'rf':
            if GPIO.input(31) == 1:
                lcd.offLed(1)
                lcd.offLed(2)
            else:
                lcd.onLed(1)
                lcd.onLed(2)
                
            if GPIO.input(33) == 1:
                lcd.offLed(3)
            else:
                lcd.onLed(3)
                
            if GPIO.input(35) == 1:
                lcd.offLed(4)
            else:
                lcd.onLed(4)
                
            if GPIO.input(37) == 1:
                lcd.offLed(5)
            else:
                lcd.onLed(5)
                
        if mode == 'app':
            mystatus = rest.get('SmartStreet/Status')
            status = mystatus[1]
            if status['one'] == 'On':
                lcd.onLed(1)
            else:
                lcd.offLed(1)
            if status['two'] == 'On':
                lcd.onLed(2)
            else:
                lcd.offLed(2)
            if status['three'] == 'On':
                lcd.onLed(3)
            else:
                lcd.offLed(3)
            if status['four'] == 'On':
                lcd.onLed(4)
            else:
                lcd.offLed(4)
            if status['five'] == 'On':
                lcd.onLed(5)
            else:
                lcd.offLed(5)
    except:
        print('error')

