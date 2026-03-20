const BASE_URL = "http://localhost:9595/api/auth";

/* ================= REGISTER ================= */

function registerUser(){

    const selectedRole =
        document.querySelector('input[name="role"]:checked');

    const user = {
        name: document.getElementById("name").value,
        email: document.getElementById("emailRegister").value,
        password: document.getElementById("passwordRegister").value,
        phone: document.getElementById("phone").value,
        location: document.getElementById("location").value,
        role: selectedRole.value
    };

    fetch(BASE_URL + "/register",{
        method:"POST",
        headers:{ "Content-Type":"application/json" },
        body:JSON.stringify(user)
    })
    .then(async response => {

        if(!response.ok){
            alert("❌ Registration Failed");
            return;
        }

        alert("✅ Registration Successful");
    })
    .catch(error=>{
        console.error("REGISTER ERROR:",error);
        alert("❌ Cannot connect backend");
    });
}


/* ================= LOGIN ================= */

function loginUser(){

    const loginData = {
        email: document.getElementById("loginEmail").value,
        password: document.getElementById("loginPassword").value
    };

    fetch(BASE_URL + "/login",{
        method:"POST",
        headers:{ "Content-Type":"application/json" },
        body:JSON.stringify(loginData)
    })
    .then(async response=>{

        const data = await response.json();   // ✅ always parse JSON

        if(!response.ok){
            alert("❌ " + data.message);   // ✅ show real message
            return;   // ❗ STOP HERE (no throw)
        }

        // ✅ SUCCESS
        alert("✅ Login Successful");

        localStorage.setItem("token", data.token);
        localStorage.setItem("role", data.role);
		localStorage.setItem("userId", data.userId); 
        localStorage.setItem("userEmail", loginData.email);

        // redirect
        if(data.role === "ADMIN"){
            window.location.href="admin.html";
        }
        else if(data.role === "RESPONDER"){
            window.location.href="responder.html";
        }
        else{
            window.location.href="citizen.html";
        }

    })
    .catch(error=>{
        console.error("LOGIN ERROR:",error);
        alert("❌ Server Error");
    });
}