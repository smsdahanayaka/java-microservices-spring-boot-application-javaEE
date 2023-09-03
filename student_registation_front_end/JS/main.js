// --- UPDATE POFILE IMAGE---

    //Create object referance from dom 
    let imageUploadInput = document.getElementById('image-upload-input');
    let selectedImage = document.getElementById('selected-image');
    let imageData;

    // Add an event listener to the input button
    imageUploadInput.addEventListener('change', function () {
        const file = imageUploadInput.files[0]; // Get the selected file

        if (file) {
            const reader = new FileReader();

            reader.onload = function (e) {
                selectedImage.src = e.target.result;
                imageData=e.target.result;
                
            };

            // Read the selected file as a data URL
            reader.readAsDataURL(file);
        }
    });


// ---CLEAR BUTTON FUNCTION---

    // Create Object referance from Dom
    let btnclear=document.getElementById("btnClear");

    // Create Objects for every input feilds
        let firstName=document.getElementById("firstName");
        let lastName=document.getElementById("lastName");
        let middleName=document.getElementById("middleName");
        let birthDay=document.getElementById("birthDay");
        let age=document.getElementById("age");
        let guardianName=document.getElementById("guardianName");
        let contactNumber=document.getElementById("contactNumber");
        let address=document.getElementById("address");

    // Clear text feild function 
    btnclear.addEventListener("click",()=>{
        firstName.value="";
        lastName.value="";
        middleName.value="";
        birthDay.value="";
        age.value="";
        guardianName.value="";
        contactNumber.value="";
        address.value="";
    });



// ---SUBMIT BUTTON FUNCTION ---

    // Create Object for submit button using dOm
    let btnSubmit=document.getElementById("btnSubmit");

    // add action to submit button
    btnSubmit.addEventListener("click",()=>{

        // check ,all feilds are filled or not 
        if(firstName.value==="" ||lastName.value==="" ||middleName.value==="" ||birthDay.value==="" ||age.value==="" ||contactNumber.value==="" ||address.value===""){
            alert("Every feild are required");
        }else{

            // create json object
            let student={
                firstName: firstName.value,
                lastName: lastName.value,
                middleName: middleName.value,
                birthDay: birthDay.value,
                age: age.value,
                guardianName: guardianName.value,
                contactNumber: contactNumber.value,
                address: address.value,
                
            };

            // fetch() method use to make POST request

            fetch("http://localhost:8080/set-student",{
                method:"POST",
                headers:{
                    'Content-Type':'application/json',
                },
                body:JSON.stringify(student),
            })
            .then(res=>{
                // check status
                if (res.status===200) {
                    firstName.value="";
                    lastName.value="";
                    middleName.value="";
                    birthDay.value="";
                    age.value="";
                    guardianName.value="";
                    contactNumber.value="";
                    address.value="";
                    alert("Done");
                    return res.json();
                }else{
                    alert("please try again");
                }
            })
            
            .catch(error=>{
                console.error('Error',error);
            });

        }
    });

    // -----> list.js