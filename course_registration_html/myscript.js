function showAvailableCourses(){
    fetch("http://localhost:8080/course/getAllCourses")
    .then((response)=>response.json())
    .then((courses)=>{
        const tableData=document.getElementById("tableData");
        courses.forEach(course => {
            var row=`<tr>
                <td>${course.courseId}</td>
                <td>${course.courseName}</td>
                <td>${course.trainer}</td>
                <td>${course.durationInWeeks}</td>
            <tr>`;

            tableData.innerHTML+=row;
        });
    })
}

function showEnrolledCourses(){
    fetch("http://localhost:8080/course/getEnrolledStudents")
    .then((response)=>response.json())
    .then((courses)=>{
        const tableData=document.getElementById("tableData");
        courses.forEach(course => {
            var row=`<tr>
                <td>${course.name}</td>
                <td>${course.emailId}</td>
                <td>${course.courseName}</td>
            <tr>`;

            tableData.innerHTML+=row;
        });
    })
}