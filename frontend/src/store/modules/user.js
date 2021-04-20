import { USER_REQUEST, USER_ERROR, USER_SUCCESS } from "../actions/user";
import Vue from "vue";
import { AUTH_LOGOUT } from "../actions/auth";

const state = {
  status: "",
  profile: {}
};

const getters = {
  getProfile: state => state.profile,
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

    commit(USER_SUCCESS, resp);

    if (resp.type != "tenant" && resp.type != "landlord") {
      dispatch(AUTH_LOGOUT)
    }
  }
};

const mutations = {
  [USER_REQUEST]: state => {
    state.status = "loading";
  },
  [USER_SUCCESS]: (state, resp) => {
    state.status = "success";
    Vue.set(state, "profile", resp);
    console.log(state.profile)
    alert("asiodjasoidj")
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