console.log("mrdcn, servi njda");

const getId = id => {
    return document.getElementById(id);
};

const register = () => {
    const body = {
        name: getId("name").value,
        username: getId("uname").value,
        email: getId("email").value,
        password: getId("pass").value,
    };

    const params = {
        method: "POST",
        headers: new Headers({"Content-Type": "application/json"}),
        body: JSON.stringify(body)
    };
    
    console.log(body, params)

};

getId("submit-btn").addEventListener('click', register);