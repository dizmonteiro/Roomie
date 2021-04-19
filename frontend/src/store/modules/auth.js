import {
    AUTH_REQUEST,
    AUTH_ERROR,
    AUTH_SUCCESS,
    AUTH_LOGOUT
  } from "@/store/actions/auth";
import { USER_REQUEST } from "@/store/actions/user";
import axios from 'axios'
  
  const state = {
    token: localStorage.getItem("user-token") || "",
    status: "",
    hasLoadedOnce: false
  };
  
  const getters = {
    isAuthenticated: state => !!state.token,
    authStatus: state => state.status
  };
  
  const actions = {
    [AUTH_REQUEST]: ({ commit, dispatch }, user) => {
      return new Promise((resolve, reject) => {
        commit(AUTH_REQUEST);
        axios({ url: "http://localhost:8083/api/auth/login", data: user, method: "POST" })
          .then(resp => {
            localStorage.setItem("user-token", resp.token);
            axios.defaults.headers.common['Authorization'] = resp.token
            commit(AUTH_SUCCESS, resp);
            dispatch(USER_REQUEST);
            resolve("landlord");
          })
          .catch(err => {
            commit(AUTH_ERROR, err);
            localStorage.removeItem("user-token");
            reject(err);
          });
      });
    },
    [AUTH_LOGOUT]: ({ commit }) => {
      return new Promise(resolve => {
        commit(AUTH_LOGOUT);
        delete axios.defaults.headers.common['Authorization']
        localStorage.removeItem("user-token");
        resolve();
      });
    }
  };
  
  const mutations = {
    [AUTH_REQUEST]: state => {
      state.status = "loading";
    },
    [AUTH_SUCCESS]: (state, resp) => {
      state.status = "success";
      state.token = resp.token;
      state.hasLoadedOnce = true;
    },
    [AUTH_ERROR]: state => {
      state.status = "error";
      state.hasLoadedOnce = true;
    },
    [AUTH_LOGOUT]: state => {
      state.token = "";
    }
  };
  
  export default {
    state,
    getters,
    actions,
    mutations
  };
  