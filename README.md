# Phonebook service

## Endpoints

PersonalInfo:

* POST http://localhost:8080/personal-info/add
````
{
    "firstName": "Sam",
    "lastName": "Wood",
    "birthDay": "1995-11-18",
    "contactId": 1
}
````

* GET http://localhost:8080/personal-info/1
* PUT http://localhost:8080/personal-info/update/1
````
{
    "firstName": "Bob",
    "lastName": "Wood",
    "birthDay": "1995-11-18",
    "contactId": 1
}
````
* DELETE http://localhost:8080/personal-info/1

MethodOfCommunication:
* GET http://localhost:8080/method-of-communication/1
* GET http://localhost:8080/method-of-communication/by-contact/1
* GET http://localhost:8080/method-of-communication?contactId=2&type=SKYPE
* POST http://localhost:8080/method-of-communication/add
````
{
    "communicationType": "SKYPE",
    "number": "123541",
    "contactId": 2
}
````
* PUT http://localhost:8080/method-of-communication/update/1
````
{
    "communicationType": "SKYPE",
    "number": "12113541",
    "description": "some description",
    "contactId": 2
}
````
* DELETE http://localhost:8080/method-of-communication/1

OurCall:

* POST http://localhost:8080/call/create

````
 {
        "type": "INPUT",
        "time": "2021-12-03T10:23:21.268836",
        "duration": "PT10M",
        "fromContactId": 2,
        "toContactId": 3
    }
````
* GET http://localhost:8080/call/all?contactId=1
* DELETE http://localhost:8080/call/2

Contact:

* GET http://localhost:8080/contact/1
* GET http://localhost:8080/contact/
* POST http://localhost:8080/contact/add
````
 {
        "nickname": "honey",
        "phoneNumber": "0936483975",
        "contactType": "FAVOURITE"
}
````
* PUT http://localhost:8080/contact/update/1
````
 {
        "nickname": "honey",
        "phoneNumber": "0936483975",
        "contactType": "FAVOURITE"
}
````
* DELETE http://localhost:8080/contact/1