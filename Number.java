```html id="jsvalidation001"

<script>

function validateForm(){

    // FIRST NAME

    let firstName = document.forms[0]["f"].value.trim();

    let namePattern = /^[A-Za-z ]+$/;

    if(firstName==""){
        alert("First Name can't be empty");
        return false;
    }

    if(!namePattern.test(firstName)){
        alert("First Name contains only letters");
        return false;
    }


    // LAST NAME

    let lastName = document.forms[0]["l"].value.trim();

    if(lastName==""){
        alert("Last Name can't be empty");
        return false;
    }

    if(!namePattern.test(lastName)){
        alert("Last Name contains only letters");
        return false;
    }


    // EMAIL VALIDATION

    let email = document.forms[0]["email"].value.trim();

    let emailPattern =
    /^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$/;

    if(email==""){
        alert("Email field can't be empty");
        return false;
    }

    if(!emailPattern.test(email)){
        alert("Invalid Email ID");
        return false;
    }


    // MOBILE NUMBER VALIDATION

    let mobile = document.forms[0]["mobile"].value.trim();

    let phonePattern = /^[6-9][0-9]{9}$/;

    if(mobile==""){
        alert("Mobile Number can't be empty");
        return false;
    }

    if(!phonePattern.test(mobile)){
        alert("Invalid Mobile Number");
        return false;
    }


    // AADHAAR VALIDATION

    let aadhaar = document.forms[0]["aadhaar"].value.trim();

    let aadhaarPattern = /^[0-9]{12}$/;

    if(aadhaar==""){
        alert("Aadhaar field can't be empty");
        return false;
    }

    if(!aadhaarPattern.test(aadhaar)){
        alert("Aadhaar must contain 12 digits");
        return false;
    }


    // PINCODE VALIDATION

    let pincode = document.forms[0]["pincode"].value.trim();

    let pinPattern = /^[0-9]{6}$/;

    if(!pinPattern.test(pincode)){
        alert("Invalid Pincode");
        return false;
    }


    // CGPA VALIDATION

    let cgpa = document.forms[0]["cgpa"].value.trim();

    if(cgpa==""){
        alert("CGPA field can't be empty");
        return false;
    }

    if(isNaN(cgpa)){
        alert("CGPA must be numeric");
        return false;
    }

    if(cgpa<0 || cgpa>10){
        alert("CGPA must be between 0 to 10");
        return false;
    }


    // DECLARATION CHECKBOX

    let declare =
    document.forms[0]["declare"].checked;

    if(!declare){
        alert("Please accept declaration");
        return false;
    }


    // SUCCESS

    alert("Validation Successful");

    return true;
}

</script>
```


```html id="formupdate001"

<form action="registration"
      method="post"
      onsubmit="return validateForm()">
```


```html id="stform001"
<!DOCTYPE html>
<html>

<head>
    <title>Student Registration Form</title>

    <style>

        body{
            font-family: Arial;
            background: linear-gradient(to right,#36d1dc,#5b86e5);
            margin:0;
            padding:0;
        }

        .container{
            width:80%;
            margin:30px auto;
            background:white;
            padding:30px;
            border-radius:15px;
            box-shadow:0px 0px 20px gray;
        }

        h1{
            text-align:center;
            color:#333;
        }

        h2{
            color:#444;
            margin-top:20px;
        }

        input[type=text],
        input[type=email],
        input[type=date],
        textarea,
        select{

            width:100%;
            padding:12px;
            margin-top:8px;
            border-radius:8px;
            border:1px solid gray;
            font-size:16px;
            transition:0.3s;
        }

        input:focus,
        textarea:focus,
        select:focus{

            border-color:#5b86e5;
            box-shadow:0px 0px 10px #5b86e5;
            outline:none;
        }

        textarea{
            height:80px;
            resize:none;
        }

        .section{
            background:#f4f4f4;
            padding:20px;
            margin-top:30px;
            border-radius:10px;
        }

        .btn{
            padding:12px 25px;
            border:none;
            border-radius:8px;
            font-size:18px;
            cursor:pointer;
            margin:20px 10px;
            transition:0.3s;
        }

        .submit{
            background:green;
            color:white;
        }

        .submit:hover{
            background:darkgreen;
            transform:scale(1.05);
        }

        .reset{
            background:red;
            color:white;
        }

        .reset:hover{
            background:darkred;
            transform:scale(1.05);
        }

    </style>

</head>

<body>

<div class="container">

<form action="registration" method="post">

<h1>Student Registration Form</h1>

<div class="section">

<h2>First Name</h2>
<input type="text" name="f">

<h2>Last Name</h2>
<input type="text" name="l">

<h2>Date Of Birth</h2>
<input type="date" name="dob">

<h2>Gender</h2>
<input type="radio" name="gender" value="Male"> Male
<input type="radio" name="gender" value="Female"> Female
<input type="radio" name="gender" value="Other"> Other

<h2>Blood Group</h2>
<input type="text" name="bg">

<h2>Aadhaar Number</h2>
<input type="text" name="aadhaar">

<h2>Nationality</h2>
<input type="text" name="nation">

<h2>Religion</h2>
<input type="text" name="religion">

<h2>Category</h2>

<select name="category">
<option>General</option>
<option>OBC</option>
<option>SC</option>
<option>ST</option>
</select>

</div>

<div class="section">

<h2>Student Mobile Number</h2>
<input type="text" name="mobile">

<h2>Parent Mobile Number</h2>
<input type="text" name="pmobile">

<h2>Student Email ID</h2>
<input type="email" name="email">

<h2>Parent Email ID</h2>
<input type="email" name="pemail">

<h2>Alternate Phone Number</h2>
<input type="text" name="altphone">

</div>

<div class="section">

<h2>Permanent Address</h2>
<textarea name="paddress"></textarea>

<h2>Current Address</h2>
<textarea name="caddress"></textarea>

<h2>City</h2>
<input type="text" name="city">

<h2>District</h2>
<input type="text" name="district">

<h2>State</h2>
<input type="text" name="state">

<h2>Pincode</h2>
<input type="text" name="pincode">

</div>

<div class="section">

<h2>School/College Name</h2>
<input type="text" name="college">

<h2>University Name</h2>
<input type="text" name="university">

<h2>Course Name</h2>
<input type="text" name="course">

<h2>Branch/Department</h2>
<input type="text" name="branch">

<h2>Semester/Year</h2>
<input type="text" name="semester">

<h2>Roll Number</h2>
<input type="text" name="roll">

<h2>Registration Number</h2>
<input type="text" name="reg">

<h2>Admission Date</h2>
<input type="date" name="admission">

<h2>Previous Qualification</h2>
<input type="text" name="qualification">

<h2>Percentage/CGPA</h2>
<input type="text" name="cgpa">

</div>

<div class="section">

<h2>Father Name</h2>
<input type="text" name="father">

<h2>Mother Name</h2>
<input type="text" name="mother">

<h2>Guardian Name</h2>
<input type="text" name="guardian">

<h2>Father Occupation</h2>
<input type="text" name="foccupation">

<h2>Mother Occupation</h2>
<input type="text" name="moccupation">

</div>

<div class="section">

<h2>Skills</h2>
<input type="checkbox" name="skills" value="Java"> Java
<input type="checkbox" name="skills" value="Python"> Python
<input type="checkbox" name="skills" value="Web"> Web Development

<h2>Hobbies</h2>
<input type="text" name="hobbies">

<h2>Languages Known</h2>
<input type="text" name="language">

</div>

<div class="section">

<input type="checkbox" name="declare">

I confirm that all information is correct.

</div>

<center>

<input type="submit" value="Submit" class="btn submit">

<input type="reset" value="Refresh" class="btn reset">

</center>

</form>

</div>

</body>

</html>
```


```java id="servlet001"
String firstName = request.getParameter("f");
String lastName = request.getParameter("l");
String dob = request.getParameter("dob");
String gender = request.getParameter("gender");
String bloodGroup = request.getParameter("bg");
String aadhaar = request.getParameter("aadhaar");
String nationality = request.getParameter("nation");
String religion = request.getParameter("religion");
String category = request.getParameter("category");

String mobile = request.getParameter("mobile");
String parentMobile = request.getParameter("pmobile");
String email = request.getParameter("email");
String parentEmail = request.getParameter("pemail");
String altPhone = request.getParameter("altphone");

String permanentAddress = request.getParameter("paddress");
String currentAddress = request.getParameter("caddress");
String city = request.getParameter("city");
String district = request.getParameter("district");
String state = request.getParameter("state");
String pincode = request.getParameter("pincode");

String college = request.getParameter("college");
String university = request.getParameter("university");
String course = request.getParameter("course");
String branch = request.getParameter("branch");
String semester = request.getParameter("semester");
String roll = request.getParameter("roll");
String reg = request.getParameter("reg");
String admission = request.getParameter("admission");
String qualification = request.getParameter("qualification");
String cgpa = request.getParameter("cgpa");

String father = request.getParameter("father");
String mother = request.getParameter("mother");
String guardian = request.getParameter("guardian");
String foccupation = request.getParameter("foccupation");
String moccupation = request.getParameter("moccupation");

String[] skills = request.getParameterValues("skills");

String hobbies = request.getParameter("hobbies");
String language = request.getParameter("language");

String declare = request.getParameter("declare");
```



```java id="validation001"

// ---------------- EMPTY VALIDATION ----------------

if(firstName.equals("") || lastName.equals("")){
    out.println("<h2>First name and Last name can't be empty</h2>");
    return;
}

if(email.equals("") || parentEmail.equals("")){
    out.println("<h2>Email fields can't be empty</h2>");
    return;
}

if(mobile.equals("") || parentMobile.equals("")){
    out.println("<h2>Mobile number fields can't be empty</h2>");
    return;
}

if(aadhaar.equals("")){
    out.println("<h2>Aadhaar field can't be empty</h2>");
    return;
}

if(city.equals("") || state.equals("") || district.equals("")){
    out.println("<h2>Address fields can't be empty</h2>");
    return;
}

if(cgpa.equals("")){
    out.println("<h2>CGPA field can't be empty</h2>");
    return;
}


// ---------------- NAME VALIDATION ----------------

Pattern namePattern = Pattern.compile("[^a-zA-Z ]");

Matcher fn = namePattern.matcher(firstName);
Matcher ln = namePattern.matcher(lastName);
Matcher fatherM = namePattern.matcher(father);
Matcher motherM = namePattern.matcher(mother);

if(fn.find()){
    out.println("<h2>Invalid First Name</h2>");
    return;
}

if(ln.find()){
    out.println("<h2>Invalid Last Name</h2>");
    return;
}

if(fatherM.find()){
    out.println("<h2>Invalid Father Name</h2>");
    return;
}

if(motherM.find()){
    out.println("<h2>Invalid Mother Name</h2>");
    return;
}


// ---------------- EMAIL VALIDATION ----------------

Pattern emailPattern = Pattern.compile(
"^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"
);

Matcher em1 = emailPattern.matcher(email);
Matcher em2 = emailPattern.matcher(parentEmail);

if(!em1.matches()){
    out.println("<h2>Invalid Student Email</h2>");
    return;
}

if(!em2.matches()){
    out.println("<h2>Invalid Parent Email</h2>");
    return;
}


// ---------------- PHONE VALIDATION ----------------

Pattern phonePattern = Pattern.compile("^[6-9][0-9]{9}$");

Matcher ph1 = phonePattern.matcher(mobile);
Matcher ph2 = phonePattern.matcher(parentMobile);

if(!ph1.matches()){
    out.println("<h2>Invalid Student Mobile Number</h2>");
    return;
}

if(!ph2.matches()){
    out.println("<h2>Invalid Parent Mobile Number</h2>");
    return;
}


// ---------------- AADHAAR VALIDATION ----------------

Pattern aadhaarPattern = Pattern.compile("^[0-9]{12}$");

Matcher aad = aadhaarPattern.matcher(aadhaar);

if(!aad.matches()){
    out.println("<h2>Aadhaar must contain 12 digits</h2>");
    return;
}


// ---------------- PINCODE VALIDATION ----------------

Pattern pinPattern = Pattern.compile("^[0-9]{6}$");

Matcher pin = pinPattern.matcher(pincode);

if(!pin.matches()){
    out.println("<h2>Invalid Pincode</h2>");
    return;
}


// ---------------- CGPA VALIDATION ----------------

try{

    double marks = Double.parseDouble(cgpa);

    if(marks < 0 || marks > 10){

        out.println("<h2>CGPA must be between 0 to 10</h2>");
        return;
    }

}
catch(Exception e){

    out.println("<h2>Invalid CGPA Format</h2>");
    return;
}


// ---------------- CHECKBOX VALIDATION ----------------

if(declare == null){

    out.println("<h2>Please accept declaration checkbox</h2>");
    return;
}


// ---------------- SUCCESS MESSAGE ----------------

out.println("<center>");
out.println("<h1 style='color:green'>Registration Successful</h1>");
out.println("</center>");
```
