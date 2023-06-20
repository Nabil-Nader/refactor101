### This will be a simple version that related to 

- Code Smell -> Duplicate Code

## Steps -> compare the main branch with this branch to see different
 
## Problem 
	'''
	  As we can see, the switch statement is being used to return different error
	 messages based on the type of exception that is thrown
	 '''

# Solution 
    - To have suche a generic behaiver in the controller we added a GlobalExceptionHandler to handel all error 
    - Remove un wanted package and classes [boilplate code ]
    - Add A generic class to handdle all the Response Request we will call it Response



```json
{
    "timestamp": "2023-06-20 11:58:16.042",
    "message": "There is no prosecutor in our database",
    "success": false,
    "status": 400,
    "data": "/refactor/products",
    "debugMessage": "java.lang.RuntimeException"
}
```


    - As for the Message we will handel this by using Resource Budle to dispplay any message whith a any language
    - This is done my having a Translator to get the message in budle depend on the langauge id, english will be a default.
    - ResourceBundleMessageSourceConfig will be a configration class, so spring will handel it each time we need it
    
