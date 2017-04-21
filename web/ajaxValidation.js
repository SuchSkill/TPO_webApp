/**
 * Created by Eugene on 21-Apr-17.
 */
var req

function validate() {
    document.getElementById("msg").value = "invalid"
    var idP1 = document.getElementById("p1");
    var idP2 = document.getElementById("p2");
    var dataP1 = encodeURIComponent(idP1.value);
    var dataP2 = encodeURIComponent(idP2.value);
    if(!dataP1 || !dataP2 ){
        console.log(dataP1)
        console.log(dataP2)
        document.getElementById("msg").innerHTML = "invalid"
        return
    }

    req = new XMLHttpRequest();
    var url = "formmvc?p1="+ dataP1 +"&p2="+dataP2
    req.open("GET", url, true);
    req.onreadystatechange = inserter
    req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    req.send(dataP1);
}

function inserter() {
    if (req.readyState == 4) {
        if (req.status == 200) {
            var msg = req.responseText
            console.log(msg)
            if (msg == "") {
                document.getElementById("msg").innerHTML = "invalid"
            }
            else
                document.getElementById("msg").innerHTML = msg
        }
    }
}