from selenium import webdriver

driver = webdriver.Chrome('/Users/miloonken/dev/chromedriver')
driver.get("http://www.google.com")
elem = driver.find_element_by_name("q")
elem.send_keys("Hello WebDriver!")
elem.submit()
print(driver.title)