
$(document).ready(function() {
    $("#submit").click(function() {
    var name = $("#Name_signup").val();
    var email = $("#email").val();
    var password = $("#password").val();
    var cpassword = $("#cpassword").val();
    var DOB = $("#DOB").val();
    var address = $("#address").val();
    var contact = $("#contact").val();
    
    if (name == '' || email == '' || password == '' || cpassword == '' || DOB== '' || address== '' || contact== '') {
    alert("Please fill all fields");}
    else if ((email.indexOf("@", 0) < 0) || (email.indexOf(".", 0) < 0) )
    {
        alert ("please enter a valid email");
    }
 else if ((password.length) < 8) 
    {
    alert("Password should atleast 8 character in length");
    } 
 else if (password != cpassword) {
    alert("Your passwords don't match. Try again?");
    } 
 else if ((contact.length) != 11) 
 {
 alert("contact number must be 11 character");
 } 
        else {


            
console.log("successful registeration");

//document.location.href='RegisterServlet';
//how did fatma implement it as function in her code
 }
    });
    });