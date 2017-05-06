var express = require('express')
const uuidV1 = require('uuid/v4');
var app = express()

var dbversion = 1;

app.get('/update/students', function (req, res) {
  dbversion++;
  res.send('OK: ' + dbversion);
})

app.get('/list/students', function (req, res) {  
  
  var version = req.query.ver;
  if (version != dbversion) {
	  setTimeout(function(){
	  	var students = [];
		  for(var i = 0; i < 20; i++) {
		  	var stu = {};
		  	stu.id = i;
		  	stu.name = uuidV1();
		  	stu.major = 'cs';
		  	students.push(stu);
		  }	
		  res.send(students);	
	  }, 5000);
	} else {
		res.send('No change.');	
	}
})

app.listen(3000, function () {
  console.log('Example app listening on port 3000!')
})
