import { useEffect } from 'react'
import { useDispatch, useSelector } from 'react-redux'

import {
  Tooltip,
  BarChart,
  XAxis,
  YAxis,
  Legend,
  CartesianGrid,
  Bar,
} from 'recharts'
import {
  getPayment,
  getRating,
  getMaxSalesProduct,
  getMonthWiseRevenue,
} from '../../actions/adminDashBoardActions'

const AdminScreen = (props) => {
  
  const paymentStore = useSelector((store) => store.paymentStore)
  

  const ratingStore = useSelector((store) => store.ratingStore)

  const maxSaleProductStore = useSelector((store) => store.maxSaleProductStore)

  const monthWiseRevenueStore = useSelector(
    (store) => store.monthWiseRevenueStore
  )
  const dispatch = useDispatch()


  useEffect(() => {
    console.log('in use effect')
    //dispatch(getAllCartItems());
    
  }, [])

  const showAllUsersHandler = () => {
    props.history.push("/get-users")
  }

  const showAllSeller = () => {
    props.history.push("/get-seller")
  }

  const showAllProducts = () => {
    props.history.push("/get-product-admin")
  }

  const showAllCompanies = () => {
    props.history.push("/show-company")
  }

  const showAllCategories = () => {
    props.history.push("/get-category")
  }

  const showAllOrders = () => {
    props.history.push("/admin-order-details")
  }

  return (
    <div id="wrapper">
      <div className="d-flex flex-column container" id="content-wrapper">
        <div id="content">
          <div className="container-fluid">
            <div className="d-sm-flex justify-content-between align-items-center mb-4">
              <h3 className="text-dark mb-0">Admin Dashboard</h3>
            </div>
            

            <div className="row">
             

              <div className="col-lg-5 col-xl-4">
                <div className="card shadow mb-4"></div>
                <div className="row">
                  <div className="col-lg-6 mb-4">
                    <div className="card text-white bg-primary shadow">
                      <div className="card-body">
                        <button className="btn btn-primary" onClick={showAllUsersHandler}>
                          Show All Users
                        </button>
                      </div>
                    </div>
                  </div>

                  <div className="col-lg-6 mb-4">
                    <div className="card text-white bg-success shadow">
                      <div className="card-body">
                        <button className="btn btn-success" onClick={showAllSeller}>
                          Show All Seller
                        </button>
                      </div>
                    </div>
                  </div>
                  <div className="col-lg-6 mb-4">
                    <div className="card text-white bg-info shadow">
                      <div className="card-body">
                        <button className="btn btn-info" onClick={showAllProducts}>
                          Show All Products
                        </button>
                      </div>
                    </div>
                  </div>
                  <div className="col-lg-6 mb-4">
                    <div className="card text-white bg-warning shadow">
                      <div className="card-body">
                        <button className="btn btn-warning" onClick={showAllCompanies}>
                          Show All Comp.
                        </button>
                      </div>
                    </div>
                  </div>
                  <div className="col-lg-6 mb-4">
                    <div className="card text-white bg-danger shadow">
                      <div className="card-body">
                        <button className="btn btn-danger" onClick={showAllCategories}>
                          Show All Category
                        </button>
                      </div>
                    </div>
                  </div>
                  <div className="col-lg-6 mb-4">
                    <div className="card text-white bg-secondary shadow">
                      <div className="card-body">
                        <button className="btn btn-secondary" onClick={showAllOrders}>
                          Show All Orders
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
    </div >
  )
}

export default AdminScreen
