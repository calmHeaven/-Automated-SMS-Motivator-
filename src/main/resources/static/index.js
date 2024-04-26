var Phone = document.getElementById("Phone");
var message = document.getElementById("msg");
var submitMsg = document.getElementById("submit");

function validatePhoneNum() {
  var phoneNum = Phone.value;

  // Improved phone number regex (consider using a library for more robust validation)
  var phoneNumPattern = /^\(?([0-9]{4})\)?[- ]?([0-9]{3})[- ]?([0-9]{4})$/;

  if (phoneNumPattern.test(phoneNum)) {
    Phone.style.border = "2px solid green";
    return true;
  } else {
    Phone.style.border = "2px solid red";
    // Display error message (example)
    alert("Invalid phone number format. Please enter a valid number.");
    return false;
  }
}

function limitMsg() {
  var msgLength = message.value.length;
  if (msgLength > 160) {
    message.style.border = "2px solid red";
    alert("Message exceeds 160 characters. Please shorten your message.");
    return false;
  } else {
    message.style.border = "2px solid green";
    return true;
  }
}

function validateForm() {
  var isValidPhone = validatePhoneNum(); // Call validatePhoneNum first
  var isValidMsg = limitMsg(); // Call limitMsg second
  return isValidPhone && isValidMsg; // Only return true if both validations pass
}

submitMsg.addEventListener("click", function() {

  if (validateForm()) {
var myHeaders = new Headers();
myHeaders.append("Content-Type", "application/json");

var raw = JSON.stringify({
  "phoneNumber": Phone.value,
  "message": message.value
});

var requestOptions = {
  method: 'POST',
  headers: myHeaders,
  body: raw,
  redirect: 'follow'
};


    fetch("http://localhost:8080/api/v1/sms", requestOptions)
      .then(response => response.text())
      .then(result => {
        console.log(result);
        successMessage.innerHTML = "SMS sent successfully!";  // Update success message
      })
      .catch(error => {
        console.log('error', error);
        successMessage.innerHTML = "Error sending SMS: " + error.message; // Update success message with error
      });
  }
});
