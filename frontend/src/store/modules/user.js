import { USER_REQUEST, USER_ERROR, USER_SUCCESS } from "../actions/user";
import Vue from "vue";
import { AUTH_LOGOUT } from "../actions/auth";

const state = {
  status: "",
  profile: {type:""}
};

const getters = {
  getType: state => state.profile.type,
  isProfileLoaded: state => !!state.profile.name
};

const actions = {
  [USER_REQUEST]: ({ commit, dispatch }, token) => {
    commit(USER_REQUEST);


    var resp = {}
    resp.type = token.type
    resp.name = token.name
    resp.email = token.email
    resp.id = token.id
    console.log("user request "+JSON.stringify(state))
    commit(USER_SUCCESS, resp);
    console.log("after user sucess "+JSON.stringify(state))
    if (resp.type != "tenant" && resp.type != "landlord") {
      dispatch(AUTH_LOGOUT)
    }
    console.log("after logout "+JSON.stringify(state))
  }
};

const mutations = {
  [USER_REQUEST]: state => {
    state.status = "loading";
  },
  [USER_SUCCESS]: (state, resp) => {
    state.status = "success";
    Vue.set(state, "profile", resp);
    console.log("user success "+JSON.stringify(state))
  },
  [USER_ERROR]: state => {
    state.status = "error";
  },
  [AUTH_LOGOUT]: state => {
    state.profile = {};
  }
};

export default {
  state,
  getters,
  actions,
  mutations
};