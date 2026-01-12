document.addEventListener("DOMContentLoaded", () => {
    console.log("DOM loaded, app.js running");
  
    const form = document.getElementById("user-form");
    const message = document.getElementById("message");
  
    if (!form) {
      console.error("Could not find form with id 'user-form'");
      return;
    }
  
    form.addEventListener("submit", async (e) => {
      e.preventDefault();
      console.log("Submit handler fired");
  
      const data = new FormData(form);
      const user = {
        userName: data.get("userName"),
        password: data.get("passWord"),
        email: data.get("email"),
        age: Number(data.get("age")),
        gender: data.get("gender"),
        bodyweight: Number(data.get("bodyweight")),
      };
  
      console.log("➡️ Sending user to backend:", user);
      
    
      try {
        const res = await fetch("http://localhost:8080/users", {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify(user),
        });
  
        console.log("Response status:", res.status);
  
        if (res.status === 409) {
          const text = await res.text();
          message.textContent = text || "User with this email already exists";
          message.style.color = "red";
          return;
        }
  
        if (!res.ok) {
          const text = await res.text();
          console.error("Backend error:", text);
          return;
        }
  
        const created = await res.json();
        // redirect after success
        setTimeout(() => {
        location.replace("./homepage.html");
        }, 800);
        console.log("Created user:", created);
  

        form.reset();
      } catch (err) {
        console.error(" Network or JS error:", err);

      }
    });
  });