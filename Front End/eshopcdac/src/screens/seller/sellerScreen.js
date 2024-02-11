import { Link } from 'react-router-dom'
 
import { useEffect, useState } from 'react'
import { useDispatch, useSelector } from 'react-redux'
import { addToCart, getAllCartItemsAtLogin } from '../../actions/cartActions'
const SellerScreen = (props) => {
  const cartLoginStore = useSelector((state) => state.cartLoginStore)
  const dispatch = useDispatch()

  // console.log(getSellerMontlyRevenueStore.response.data.total)

  useEffect(() => {
    console.log('in use effect')
    dispatch(getAllCartItemsAtLogin()); 
  }, [])

  const showProduct = () => {
    props.history.push('/show-product')
  }

  const viewAllCustomerMyorders = () => {
    props.history.push('/all-customers-myorders-for-seller')
  }

  const addProduct = () => {
    props.history.push('/add-product')
  }

  return (
    <div className="seller-div">
      <div id="wrapper">
        <div className="d-flex flex-column container" id="content-wrapper">
          <div id="content">
            <div className="container-fluid">
              <div className="d-sm-flex justify-content-between align-items-center mb-4">
                <h3 className="text-dark mb-0">Seller Dashboard</h3>
              </div>
              

               <div className="row"> 
                <div className="col-lg-5 col-xl-4">
            
                  <div className="row">
                    <div className="col-lg-6 mb-4">
                      <div className="card text-white bg-success shadow">
                        <div className="card-body">
                          <button
                            className="btn btn-success"
                            onClick={showProduct}>
                            Show Products
                          </button>
                        </div>
                      </div>
                    </div>
                    <div className="col-lg-6 mb-4">
                      <div className="card text-white bg-info shadow">
                        <div className="card-body">
                          <button
                            className="btn btn-info"
                            onClick={viewAllCustomerMyorders}>
                            Customer Orders
                          </button>
                        </div>
                      </div>
                    </div>
                    <div className="col-lg-6 mb-4">
                      <div className="card text-white bg-secondary shadow">
                        <div className="card-body">
                          <button
                            className="btn btn-secondary"
                            onClick={addProduct}>
                            Add Product
                          </button>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  )
}

export default SellerScreen
