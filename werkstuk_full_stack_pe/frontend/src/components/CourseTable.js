import React, { Component } from 'react'
import DeleteForm from './DeleteForm'
import AddCourseForm from './AddCourseForm'

class CourseTable extends Component {
  state = {
    Courses: []
  }

  componentDidMount = () => {
    fetch('http://localhost:8080/api/courses', {
      method: 'GET',
      headers: {
        accept: 'application/json'
      }
    })
      .then((res) => {
        if (res.ok) return res.json()
        console.log(`error: ${res}`)
      })
      .then((json) => {
        console.log(`courses: ${json}`)
        this.setState({ Courses: json })
      })
      .catch((err) => {
        console.log(`error: ${err}`)
      })
  }

  createCourseHandler = (courseForm) => {
    console.log('add course createCourseHandler')
    fetch(
      `http://localhost:8080/api/courses/add?name=${courseForm.name}&description=${courseForm.description}&price=${courseForm.price}`,
      {
        method: 'POST',
        headers: {
          'Content-Type': 'x-www-form-url-encoded',
          accept: 'application/json'
        }
      }
    )
      .then((res) => {
        if (res.ok) {
          console.log(`create product response: ${res.status}`)
          return res.json()
        }
        console.log(`create product error: ${res.statusText}`)
      })
      .then((json) => {
        console.log(
          `product created, got: ${JSON.stringify(json)}, ${JSON.stringify(
            courseForm
          )}`
        )
        this.componentDidMount()
      })
      .catch((err) => {
        console.log(`error: ${err}`)
      })
  }

  deleteCurrent = (currentId) => {
    fetch(`http://localhost:8080/api/courses/delete/${currentId}`, {
      method: 'DELETE',
      headers: { accept: 'application/json' }
    })
      .then((res) => {
        if (res.ok) {
          console.log('delete')
          this.componentDidMount(console.log(currentId))
          return res.json()
        }
      })
      .catch((err) => {
        console.log(`error: ${err}`)
      })
  }

  render() {
    return (
      <div className='mt-5'>
        <h1>Courses</h1>
        <AddCourseForm onSubmit={this.createCourseHandler} />
        <div className='table'>
          <table>
            <thead></thead>
            <tbody></tbody>
          </table>

          <table className='table'>
            <thead className='thead-dark'>
              <tr>
                <th scope='col'>Name</th>
                <th scope='col'>Description</th>
                <th scope='col'>Price</th>
                <th scope='col'>Delete</th>
              </tr>
            </thead>
            <tbody>
              {this.state.Courses.map((course, index) => {
                return (
                  <tr key={course.id}>
                    <td>{course.name}</td>
                    <td>{course.description}</td>
                    <td>{course.price}</td>
                    <td>
                      <DeleteForm
                        currentId={course.id}
                        onSubmit={this.deleteCurrent}
                      />
                    </td>
                  </tr>
                )
              })}
            </tbody>
          </table>
        </div>
      </div>
    )
  }
}

export default CourseTable
