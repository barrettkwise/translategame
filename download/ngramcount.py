import socket
import requests
import urllib
from decimal import *

def word2(word):  
    word = word.replace("'", '', -1)
    print("Word sent to api: ", word)
    encoded_query = urllib.parse.quote(word)
    params = {'corpus': 'eng-us', 'query': encoded_query, 'topk': 3, 'format': 'tsv'}
    params = '&'.join('{}={}'.format(name, value) for name, value in params.items())
    response = requests.get('https://api.phrasefinder.io/search?' + params)
    assert response.status_code == 200
    print(response.text)
    results = response.text
    results2 = results.split()
    finalresult = results2[6]
    finalresult = bytes(finalresult, 'utf-8')
    return finalresult
    
def phrases(word):
    phrase = []
    if "1" in word:
        phrase = ["hello", "there", "good", "sir"]
    elif "2" in word:
        phrase = ["hows", "the", "weather", "today"]
    elif "3" in word:
        phrase = ["a", "dime", "a", "dozen"]
    elif "4" in word:
        phrase = ["back", "to", "square", "one"]
    print(phrase, type(phrase))
    x = 0
    listresults = []
    ##convert list to string 
    while x < 4:
        word2 = phrase[x]
        print("Word #", x, " sent to api.")
        word2 = word2.replace("'", '', -1) 
        encoded_query = urllib.parse.quote(word2)
        params = {'corpus': 'eng-us', 'query': encoded_query, 'topk': 2, 'format': 'tsv'} 
        params = '&'.join('{}={}'.format(name, value) for name, value in params.items()) 
        response = requests.get('https://api.phrasefinder.io/search?' + params)
        assert response.status_code == 200
        print(response.text)
        results = response.text
        results2 = results.split()
        finalresult2 = results2[6]
        finalresult2 = float(finalresult2)
        print(type(finalresult2))
        listresults.append(finalresult2)
        x = x + 1
    print(listresults)
    y = 0
    addsum = 0
    while y < 4:
        num = listresults[y]
        addsum = num + addsum
        y = y + 1
    average = addsum / 4
    getcontext().prec = 2
    average = Decimal(average).quantize(Decimal('0.01'), rounding = ROUND_UP)
    print(average)
    average = average.to_eng_string()
    print(average)
    average = bytes(average, 'utf-8')
    print("Number sent to Java: ", average)
    return average

def main():
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
        s.bind(("localhost", 9000))
        s.listen(10) 
        connection, address = s.accept()
        with connection:
           print("Connected to: ", address)
           word = connection.recv(1024)
           print ("Word(s) received: ", word)
           word = str(word)
           word = word.replace('b', '', 1)
           if len(word) == 3:
               average = phrases(word)
               ##sending phrase to java
               connection.send(average)
               connection.close()
           else:
               finalresult = word2(word)
               ##sending word to java
               connection.send(finalresult)
               connection.close()
               
main()
