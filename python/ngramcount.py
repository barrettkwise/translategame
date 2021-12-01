import socket
import requests
import urllib

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
    phrase = word.split(",", -1)
    print(phrase, type(phrase))
    x = 0
    ##convert list to string 
    while x < 4:
        word2 = phrase[x]
        print(x)
        word2 = word2.replace("'", '', -1) 
        x = x + 1
        wordphrase = ""
        wordphrase = word2 + wordphrase 
    print(wordphrase)
    wordphrase = bytes(word2, 'utf-8')
    encoded_query = urllib.parse.quote(wordphrase)
    params = {'corpus': 'eng-us', 'query': encoded_query, 'topk': 3, 'format': 'tsv'} 
    params = '&'.join('{}={}'.format(name, value) for name, value in params.items()) 
    response = requests.get('https://api.phrasefinder.io/search?' + params)
    assert response.status_code == 200
    print(response.text)
    results = response.text
    results2 = results.split()
    finalresult2 = results2[6]
    finalresult2 = bytes(finalresult2, 'utf-8')
    return finalresult2

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
           if "," in word:
               finalresult2 = phrases(word)
               ##sending phrase to java
               connection.send(finalresult2)
               connection.close()
           else:
               finalresult = word2(word)
               ##sending word to java
               connection.send(finalresult)
               connection.close()
               
main()
