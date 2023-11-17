import RPi.GPIO as GPIO
GPIO.setmode(GPIO.BOARD)
GPIO.setup( 3,GPIO.IN)
GPIO.setup(40 ,GPIO.OUT)

while True:
    var=GPIO.input(3)
    print(var)
    if var==1:
        GPIO.output( 40,True)
        print('Water')
    else:
        GPIO.output( 40,False)
        print('No Water')
GPIO.cleanup()