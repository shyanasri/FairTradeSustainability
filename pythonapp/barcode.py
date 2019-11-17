# import the necessary packages
import numpy as np
import argparse
import imutils
import cv2
from pyzbar import pyzbar
import requests
import json
import csv

import pprint 
pp = pprint.PrettyPrinter(indent=4)

response = {
			"Manufacturer": "" ,
			"Brand" : "", 
			"Type" 	: "",
			"Description" : "",
			"isSustainable":"",
			"Alternatives":""
			}

#For demo purposes, the picture is included in folder
image = cv2.imread('barcodeunsustainable_08.jpg') #this image can be changed to others in the folder
gray_img = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)
barcodes = pyzbar.decode(gray_img)

barcodeData = barcodes[0].data.decode("utf-8") #retrieves barcode number

#Calls an API service which retrieves barcode information based on barcode number
apiresponse = requests.get("https://api.barcodelookup.com/v2/products?barcode={}&formatted=y&key=smbn8vc0ovy8hlhy8bd2mts4umcadx".format(barcodeData))
info = apiresponse.json()

#retrieve the products manufacturer, brand, and product type
response['Manufacturer'] = info['products'][0]['manufacturer']
response['Brand'] = info['products'][0]['brand']
response['Type'] = ((info['products'][0]['category']).split("> "))[-1] 
response['Description'] = info['products'][0]['description']

sustainable = False #default

#Retrieving sustainable product library
with open('FairTradeCompanies.csv', encoding = 'cp1252') as f:
    sustainablelist = [{k: v for k, v in row.items()}
        for row in csv.DictReader(f, skipinitialspace=True)]

#stops false matches if empty
if response['Manufacturer'] == '':
	response['Manufacturer'] = "Manufacturer not found."
if response['Brand'] == '':
	response['Brand'] = "Brand not found."

#check both company and brand as what is considered a manufacturer or brand differs based on source
for item in sustainablelist:

	#eliminate false matches if string is empty
	if item['Company Name'] == '':
		item['Company Name'] = "Manufacturer doesn't exist."
	if item['Brand'] == '':
		item['Brand'] = "Brand doesn't exist."

	if item['Company Name'] in response['Manufacturer'] or item['Brand'] in response['Manufacturer'] or item['Company Name'] in response['Brand'] or item['Brand'] in response['Brand']:
		sustainable = True

response['isSustainable'] = str(sustainable)
#Find 5 alternatives if product is not sustainable
count = 0
alternatives = []
if (sustainable == False): 
	for item in sustainablelist:
		if response['Type'] in item['Category']:
			alt = {
				"Manufacturer": item['Company Name'] ,
				"Brand" : item['Brand'], 
				"Type" 	: item['Category'],
				"isSustainable":"True"
			}
			alternatives.append(alt)
		count = count + 1
		if count == 4:
			break

response['Alternatives'] = alternatives
pp.pprint(response)

