import React, { Component } from 'react'

class DeleteForm extends Component {
  state = {
    currentId: this.props.currentId,
    parent: this.props.parent
  }

  deleteCurrent = () => {
    fetch(`http://localhost:8080/api/courses/delete/${this.state.currentId}`, {
      method: 'DELETE',
      headers: { accept: 'application/json' }
    })
      .then((res) => {
        if (res.ok) {
          console.log('delete')
          return res.json()
        }
      })
      .catch((err) => {
        console.log(`error: ${err}`)
      })

    this.componentDidMount()
  }

  render() {
    return (
      <form>
        <button className='btn btn-danger' onClick={this.deleteCurrent}>
          delete
        </button>
      </form>
    )
  }
}

export default DeleteForm
