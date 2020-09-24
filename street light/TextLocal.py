import urllib
class TextLocal:
    
    def sendSMS(self, numbers, message):
        params = {'apikey': '+LmrDGoS3hQ-WOqBVACdX7cMHYBRpdEO6kbeB0xipS', 'numbers': numbers, 'message' : message, 'sender': 'TXTLCL'}
        f = urllib.request.urlopen('https://api.textlocal.in/send/?'
        + urllib.parse.urlencode(params))
        return (f.read(), f.code)

