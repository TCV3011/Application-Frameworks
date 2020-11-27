import React, { Component } from 'react'

class AddCourseForm extends Component {
  constructor(props) {
    super(props)
    this.state = { name: '', description: '', price: '' }
    this.handleInputChange = this.handleInputChange.bind(this)
  }

  submitHandler = () => {
    this.props.onSubmit(this.state)
  }

  handleInputChange(event) {
    const target = event.target
    const value = target.type === 'checkbox' ? target.checked : target.value
    const name = target.name

    this.setState({
      [name]: value
    })
  }

  render() {
    return (
      <form className='mb-4'>
        <div className='row'>
          <div className='col-md-8'>
            <div className='form-group'>
              <label htmlFor='name'>Name:</label>
              <input
                className='form-control'
                type='text'
                id='name'
                required
                name={'name'}
                value={this.state.name}
                onChange={this.handleInputChange}
              ></input>
            </div>
          </div>
          <div className='col-md-4'>
            <div className='form-group'>
              <label htmlFor='price'>Price:</label>
              <input
                className='form-control'
                type='number'
                id='price'
                min='0'
                required
                name={'price'}
                value={this.state.price}
                onChange={this.handleInputChange}
              ></input>
            </div>
          </div>
        </div>
        <div className='form-group'>
          <label htmlFor='description'>Description:</label>
          <textarea
            className='form-control'
            id='description'
            required
            name={'description'}
            rows='10'
            value={this.state.description}
            onChange={this.handleInputChange}
          ></textarea>
        </div>
        <button onClick={this.submitHandler} className='btn btn-secondary'>
          Create
        </button>
        <hr />
      </form>
    )
  }
}

export default AddCourseForm
