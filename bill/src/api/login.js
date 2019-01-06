import request from '@/request'

export function login(account, password) {
  const data = {
    account,
    password
  }
  return request({
    url: 'http://localhost:8081/login',
    method: 'post',
    data
  })
}

export function logout() {
  return request({
    url: 'http://localhost:8081/logout',
    method: 'get'
  })
}

export function getUserInfo() {
  return request({
    url: 'http://localhost:8081/users/currentUser',
    method: 'get'
  })
}

export function register(account, auth, password) {
	const data = {
    account,
    auth,
    password
  }
  return request({
    url: 'http://localhost:8081/register',
    method: 'post',
    data
  })
}

export function complete(eename, email,address,lgname,idcard) {
  const data = {
    eename,
    email,
    address,
    lgname,
    idcard,
  }
  return request({
    url: 'http://localhost:8081/addinfo',
    method: 'post',
    data
  })
}
export function ha() {
  return request({
    url: 'http://localhost:8081/getuserinfo',
    method: 'get'
  })
}
