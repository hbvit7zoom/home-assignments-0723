console.log("I am script!")

window.addEventListener('DOMContentLoaded', function () {
  main()
})

function main() {
  const root = document.getElementById('root')
  let appComponent = new App()
  draw(root, appComponent)
}

function draw(container, component) {
  let fRender = component.render()
  fRender(container)
}

class Component {
  props = {}
  state = {}

  constructor(props) {
    this.props = props
  }

  render() {
    return (parent) => {

    }
  }
}

class App extends Component {

  constructor(props) {
    super(props)
    this.state = {}

    this.handleChange = this.handleChange.bind(this)
  }

  handleChange(event) {
    console.log(this.state)
    this.state.value = event.target.value
    console.log(this.state)
  }

  render() {
    return (parent) => {
      let div = document.createElement('div')
      let textField = new TextField({label: "Label Name", placeholder: "Ivan", className: "text-filed-class", onChange: this.handleChange})
      let fRender = textField.render()
      fRender(div)

      let textField2 = new TextField({label: "Text Filed 2", placeholder: "Nikita", className: "text-filed-class", onChange: this.handleChange})
      fRender = textField2.render()
      fRender(div)
      parent.append(div)

    }
  }
}

class TextField extends Component {

  constructor(props) {
    super(props)
    this.state = {}
  }

  render() {
    return (parent) => {
      console.log(this.state)
      let div = document.createElement('div')
      let label = document.createElement('label')
      label.className = this.props.className
      let input = document.createElement('input')
      label.append(document.createTextNode(this.props.label))
      label.append(input)
      input.placeholder = this.props.placeholder
      input.onchange = this.props.onChange
      div.append(label)
      parent.append(div)
    }
  }
}


