
// ---VIEW LIST OF STUDENTS ---

// SET TABLE HEADERS
let tblObj= document.getElementById("tbl");

let tblRow = `
    <tr>
        <th>First Name</th>
        <th>Middle Name</th>
        <th>Last Name</th>
        <th>Birth Day</th>
        <th>Age</th>
        <th>Guardian Name</th>
        <th>Address</th>
        <th>Contact Number</th>
    </tr>`;

// SET ACTION LISTENER TO student_list.html PAGE
document.addEventListener("DOMContentLoaded",()=>{

    // CHECK IS IT student_list.html OR NOT
    if(window.location.href.includes('/student_list.html')){

        // CALL GET API 
        fetch("http://localhost:8080/get-studentList")
        .then(res=>res.json())
        .then(json=>{

            // SET TABLE DATA
            json.forEach(element => {
            tblRow += `<tr>
                            <td>${element.firstName}</td>
                            <td>${element.middleName}</td>
                            <td>${element.lastName}</td>
                            <td>${element.birthDay}</td>
                            <td>${element.age}</td>
                            <td>${element.guardianName}</td>
                            <td>${element.address}</td>
                            <td>${element.contactNumber}</td>
                            </tr>`;
             });
             tblObj.innerHTML=tblRow;
            
             

            // Select Student Data In Table Row 
            // get table row objects array. using table object
            let rowsTable=tblObj.getElementsByTagName("tr");

            for(i=0;i<rowsTable.length;i++){
                rowsTable[i].addEventListener("click",function(){

                    let tblData=this.getElementsByTagName("td");

                    // get div objects
                    let nameDiv=document.getElementById("name-div");
                    let studentDive=document.getElementById("student-div");
                    let guardianDiv=document.getElementById("guardian-div");

                    // set data to lables
                    nameDiv.innerHTML= `
                                        <label for="Name">${tblData[0].textContent} ${tblData[1].textContent} ${tblData[2].textContent}</label>                
                                        `
                    studentDive.innerHTML=`
                                            <p><u><b>STUDENT</b></u></p>
                                            <label for="firstName"><b>Birth Day  :</b>  ${tblData[3].textContent}</label><br><br>
                                            <label for="firstName"><b>Age  :</b>  ${tblData[4].textContent}</label><br>
                                            `
                    guardianDiv.innerHTML=`
                                            <p><u><b>GUARDIAN</b></u></p>
                                            <label for="firstName"><b>Guardian Name :</b> ${tblData[5].textContent}</label><br>
                                            <label for="firstName"><b>Address  :</b> ${tblData[6].textContent}</label><br>  
                                            <label for="firstName"><b>Contact Number :</b> ${tblData[7].textContent}</label><br>
                                            `
                });
            }
            
            })
            .catch(error => {
            console.error('Error:', error);
            });                                                                  
        }
    


});