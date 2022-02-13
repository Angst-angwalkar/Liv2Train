Steps to Run/Execute the project.

Step 1:
Clone the project from git using the following:

STEP 2:
git clone https://github.com/Angst-angwalkar/Liv2Train.git

STEP 3:
Install/Setup MongoCompass for Database monitoring.

STEP 4:
An instance of MongoDB running locally (localhost:27017) is necessary for Object Creation/Retrieval.

STEP 5:
After MongoDB Instance is setup and running successfully, Run the Liv2TrainApplication.java in IDE as a "Java Application".

Once the server is up and running, the following API endpoints can be accessed.


================================API ENDPOINTS============================================
CREATE TRAINING CENTER

URL: localhost:8080/centers/save-center
Request Type: POST
Request Body: raw/json
body: {
    "centerCode": "ABCD1234EFG2",
    "centerName": "Spring Courses",
    "address": {
        "detailed_Address": "zxca",
        "city": "Mum",
        "state": "Mah",
        "pincode": "400101"
    },
    "courses_Offered": ["Java", "Spring"],
    "contactEmail": "abd@gmail.com",
    "contactPhone": "9702384863",
    "student_Capacity": 13
}


RETRIEVE TRAINING CENTER BY CENTER CODE
URL: localhost:8080/centers/ABCD1234EFG5
Request Type: GET
Request Body: None
Request Param: CenterCode Eg. ABCD1234EFG5 as present in the aforementioned URL



RETRIEVE ALL TRAINING CENTER DATA
localhost:8080/centers/
Request Type: GET
Request Body: None





