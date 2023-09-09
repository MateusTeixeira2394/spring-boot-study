# Spring boot study

## Motivation

I created this API to learn about the spring boot framework. This project is a CRUD API to a tiny doctor's application.

## Routes

### POST /doctors

it handle with the creation of doctors.

Request body:
```json
{
    "name":"String",
    "email":"doctors_name@easydoc.com",
    "telephone":"(99)99999-9999",
    "crm": "333333",
    "speciality": "String",
    "addresses": [{
        "number": 999,
        "street": "String",
        "neighborhood": "String",
        "complement": "String",
        "city": "String",
        "state": "String",
        "country": "String",
        "zipcode": "99999-999"
    }
    ]
}
```

### GET /doctors?page=0&size=10&sort=name

It returns a object with information about pagination and its content attribute has the list of the doctors. By pattern, the maximum size per search is 10 doctors and they are ordered by their name.

Response Body:
```json

{
    "content": [
        {
            "id": 1,
            "name": "String",
            "email": "doctor_name@easydoc.com",
            "crm": "99999",
            "speciality": "String"
        }
    ],
    "pageable": {
        "sort": {
            "empty": false,
            "sorted": true,
            "unsorted": false
        },
        "offset": 0,
        "pageNumber": 0,
        "pageSize": 10,
        "unpaged": false,
        "paged": true
    },
    "last": true,
    "totalElements": 2,
    "totalPages": 1,
    "size": 10,
    "number": 0,
    "sort": {
        "empty": false,
        "sorted": true,
        "unsorted": false
    },
    "first": true,
    "numberOfElements": 2,
    "empty": false
}


```

### GET /doctors/:doctorId

It returns a object with full doctor's information.

Response body:
```json
{
    "name":"String",
    "email":"doctors_name@easydoc.com",
    "telephone":"(99)99999-9999",
    "crm": "333333",
    "speciality": "String",
    "addresses": [{
        "number": 999,
        "street": "String",
        "neighborhood": "String",
        "complement": "String",
        "city": "String",
        "state": "String",
        "country": "String",
        "zipcode": "99999-999"
    }
    ]
}
```

### PATCH /doctors

It handle with doctor's update. You must send the id who you want to update and only the attributes that will be changed. In a nutshell, you shouldn't send all attributes. 

Request body:
```json

{
    "id":1,
    "addresses": [
        {
            "id": 1
        },
        {
            "id": 2
        }
    ]
}

```

### DELETE /doctors/:doctorId

It handle with doctor's deletion. This is a logical deletion. That means, the object ins't exactly deleted, but his attribute "activated" is set to false.

