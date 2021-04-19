import { USER_REQUEST, USER_ERROR, USER_SUCCESS } from "../actions/user";
import Vue from "vue";
import { AUTH_LOGOUT } from "../actions/auth";

const state = { status: "", email: "", type: "", name: "" };

const getters = {
  getProfile: state => state.profile,
  getType: state => state.profile.type,
  isProfileLoaded: state => !!state.profile.name
};

const actions = {
  [USER_REQUEST]: ({ commit, dispatch }) => {
    commit(USER_REQUEST);

    var resp = {}
    resp.type = "landlord"
    resp.name = "Madje"
    resp.email = "a@a.pt"
    
    commit(USER_SUCCESS, resp);

    if(resp.type == "qqcoisa"){
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
    Vue.set(state, "type", resp.type);
    Vue.set(state, "email", resp.email);
    Vue.set(state, "name", resp.name);
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