
import json
import yaml
from yaml import load, dump
import ConfigParser
import pyswagger


data = load(open('baseSwagger.yaml', 'r'))
#
title = data["info"]["title"]
# title = title.lower
# arr = str(title).split(" ")
# print "-".join(arr)

#title = "Sample(*&*&(*-title example"
title = title.replace("-", " ")

title=title.lower()
arr = str(title).split(" ")

for idx, subtitles in enumerate(arr):
    subtitles.isalnum()
    arr[idx] = ''.join(e for e in subtitles if e.isalnum())
xIbmName= "-".join(arr)

#dump data in template

template=load(open('Template.yaml', 'r'))
template['x-ibm-name']=xIbmName

#reading values from property file
Config = ConfigParser.ConfigParser()
Config.read("propertyFile.ini")
print Config.sections()
timeout=Config.get("ServerConfig", "count")
verb=Config.get("ServerConfig", "verb")
targetUrl=Config.get("ServerConfig", "target-url")

template['x-ibm-configuration']['assembly']['execute'][0]['invoke']['verb'] = verb
template['x-ibm-configuration']['assembly']['execute'][0]['invoke']['timeout'] = timeout
template['x-ibm-configuration']['assembly']['execute'][0]['invoke']['target-url'] = targetUrl

#dumping into template
with open('Template.yaml','w') as outdata :
    yaml.dump(template,outdata)

#read from template
templateData = load(open('Template.yaml', 'r'))
xIbmName=templateData['x-ibm-name']


xIbmConfuguration=templateData['x-ibm-configuration']

with open('baseSwagger.yaml', 'w') as apicproperties:
  apicproperties['x-ibm-name'] =xIbmName
  apicproperties['x-ibm-configuration']=xIbmConfuguration

print json.dump(apicproperties, indent=4, sort_keys=True)


#print json.dumps(template, indent=4, sort_keys=True)


