from selenium import webdriver
from selenium.webdriver.common.keys import Keys
import time
from bs4 import BeautifulSoup
from selenium.webdriver.common.by import By

driver = webdriver.Firefox() 

driver.get('https://map.kakao.com/')