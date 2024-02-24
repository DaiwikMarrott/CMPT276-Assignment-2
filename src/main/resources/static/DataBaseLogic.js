document.addEventListener('DOMContentLoaded', function () 
{
    const studentList = document.getElementById('student-list');
    const addStudentBtn = document.getElementById('add-student-btn');
    const studentForm = document.getElementById('student-form');
    const saveBtn = document.getElementById('save-btn');
    const cancelBtn = document.getElementById('cancel-btn');
    const formTitle = document.getElementById('form-title');

    let students = []; // Array to store student data

    addStudentBtn.addEventListener('click', () => 
    {
        showStudentForm('Add Student');
    });

    cancelBtn.addEventListener('click', () => 
    {
        hideStudentForm();
    });

    saveBtn.addEventListener('click', () => 
    {
        const name = document.getElementById('name').value;
        const weight = parseFloat(document.getElementById('weight').value);
        const height = parseFloat(document.getElementById('height').value);
        const hairColor = document.getElementById('hair-color').value;
        const gpa = parseFloat(document.getElementById('gpa').value);

        if (!name || isNaN(weight) || isNaN(height) || !hairColor || isNaN(gpa)) {
            alert('Please fill in all fields with valid values.');
            return;
        }

        const student = { name, weight, height, hairColor, gpa };

        // Check if the form is in edit mode
        const existingStudentIndex = students.findIndex(s => s.editMode);
        if (existingStudentIndex !== -1) {
            students[existingStudentIndex] = student;
        } else {
            students.push(student);
        }

        renderStudentList();
        hideStudentForm();
    });

    studentList.addEventListener('click', (event) => {
        const target = event.target;
        const studentCard = target.closest('.student-card');

        if (studentCard) {
            const studentIndex = studentCard.dataset.index;

            if (target.classList.contains('delete-btn')) {
                // Delete student
                students.splice(studentIndex, 1);
                renderStudentList();
            } else if (target.classList.contains('edit-btn')) {
                // Edit student
                const student = students[studentIndex];
                showStudentForm('Edit Student');
                fillFormFields(student);
                student.editMode = true;
            }
        }
    });

    // Function to render the student list on the webpage
    function renderStudentList() {
        studentList.innerHTML = ''; // Clear existing content

        students.forEach((student, index) => {
            const studentCard = document.createElement('div');
            studentCard.classList.add('student-card');
            studentCard.dataset.index = index;

            studentCard.innerHTML = `
                <h3>${student.name}</h3>
                <p>Weight: ${student.weight} lbs</p>
                <p>Height: ${student.height} inches</p>
                <p>Hair Color: ${student.hairColor}</p>
                <p>GPA: ${student.gpa}</p>
                <button class="edit-btn">Edit</button>
                <button class="delete-btn">Delete</button>
            `;

            studentList.appendChild(studentCard);
        });
    }

    // Function to show the student form
    function showStudentForm(title) {
        formTitle.textContent = title;
        studentForm.classList.remove('hidden');
    }

    // Function to hide the student form
    function hideStudentForm() {
        formTitle.textContent = 'Add Student';
        studentForm.classList.add('hidden');
        clearFormFields();
    }

    // Function to fill form fields with student data
    function fillFormFields(student) {
        document.getElementById('name').value = student.name;
        document.getElementById('weight').value = student.weight;
        document.getElementById('height').value = student.height;
        document.getElementById('hair-color').value = student.hairColor;
        document.getElementById('gpa').value = student.gpa;
    }

    // Function to clear form fields
    function clearFormFields() {
        document.getElementById('name').value = '';
        document.getElementById('weight').value = '';
        document.getElementById('height').value = '';
        document.getElementById('hair-color').value = '';
        document.getElementById('gpa').value = '';
    }
});