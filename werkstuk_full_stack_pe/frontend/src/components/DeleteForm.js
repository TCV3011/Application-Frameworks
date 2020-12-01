import React, { Component } from 'react'

class DeleteForm extends Component {
  constructor(props) {
    super(props)
    this.state = {
      currentId: this.props.currentId
    }
  }

  submitHandler = () => {
    console.log('delete submitHandler')
    this.props.onSubmit(this.state.currentId)
    console.log('delete submitHandler after onSubmit')
    this.setState({})
    console.log('delete submitHandler after setState')
  }

  render() {
    return (
      <div>
        <button className='btn btn-danger' onClick={this.submitHandler}>
          delete
        </button>
      </div>
    )
  }
}

export default DeleteForm
