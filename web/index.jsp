<%--
  Created by IntelliJ IDEA.
  User: Eugene
  Date: 26-Mar-17
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
  <%--<script type="text/javascript" language="javascript" src="ajaxValidation.js"></script>--%>
  <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
  <script language="javascript" type="text/javascript">
      var req

      var timeout = setInterval(time, 500);
      function time() {
          console.log("1")
          req = new XMLHttpRequest();
          var url = "time"
          req.open("GET", url, true);
          req.onreadystatechange = updateTime
          req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
          req.send();
      }
      function updateTime() {
          if (req.readyState == 4) {
              if (req.status == 200) {
                  var msg = req.responseText
                  console.log(msg)
                  if (msg == "") {
                      document.getElementById("time").innerHTML = "invalid"
                  }
                  else
                      document.getElementById("time").innerHTML = msg
              }
          }
      }


      function validate() {
          console.log("2")
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
          console.log(3)
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
  </script>
  <title>Sum</title>
</head>
<body>
<h2>Sum two elements</h2>
<hr>
  p1<input id="p1" type="text" size="50" name="p1" onblur="validate()"><br>
  p2<input id="p2" type="text" size="50" name="p2" onblur="validate()"><br>


<div id="msg"></div>

</body></html>
