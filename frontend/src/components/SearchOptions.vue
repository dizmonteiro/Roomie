<template>
  <div class="columns">
    <div
      class="column is-one-third-desktop is-one-third-tablet is-one-third-mobile"
    >
      <div class="field">
        <form v-on:submit.prevent="noop">
        <p class="control has-icons-left">
          <input class="input" id="title_input" type="search" placeholder="Title" v-on:keyup.enter="titleParam"/>
          <span class="icon is-small is-left">
            <i class="fas fa-search"></i>
          </span>
        </p>
        </form>
      </div>
    </div>
    <div
      class="column is-one-fifth-desktop is-one-fifth-tablet is-one-fifth-mobile"
    >
      <div class="field">
        <form v-on:submit.prevent="noop">
        <p class="control has-icons-left">
          <input class="input" id="city_input" type="search" placeholder="City" v-on:keyup.enter="cityParam"/>
          <span class="icon is-small is-left">
            <i class="fas fa-search"></i>
          </span>
        </p>
        </form>
      </div>
    </div>
    <div
      class="column is-one-third-desktop is-one-third-tablet is-one-third-mobile"
    >
      <div class="dropdown is-hoverable">
        <div class="dropdown-trigger">
          <button
            class="button"
            aria-haspopup="true"
            aria-controls="dropdown-menu"
          >
            <span>Bedrooms</span>
            <span class="icon is-small">
              <i class="fas fa-angle-down" aria-hidden="true"></i>
            </span>
          </button>
        </div>
        <div class="dropdown-menu" id="dropdown-menu" role="menu">
          <div class="dropdown-content">
            <a class="dropdown-item" @click="bedroomParam(1)">1</a>
            <a class="dropdown-item" @click="bedroomParam(2)">2</a>
            <a class="dropdown-item" @click="bedroomParam(3)">3</a>
            <a class="dropdown-item" @click="bedroomParam(4)">4</a>
            <a class="dropdown-item" @click="bedroomParam(5)">5</a>
          </div>
        </div>
      </div>
      <div class="dropdown is-hoverable">
        <div class="dropdown-trigger">
          <button
            class="button"
            aria-haspopup="true"
            aria-controls="dropdown-menu"
          >
            <span>Price Range</span>
            <span class="icon is-small">
              <i class="fas fa-angle-down" aria-hidden="true"></i>
            </span>
          </button>
        </div>
        <div class="dropdown-menu" id="dropdown-menu" role="menu">
          <div class="dropdown-content">
            <a class="dropdown-item" @click="priceParam(100)">100€</a>
            <a class="dropdown-item" @click="priceParam(200)">200€</a>
            <a class="dropdown-item" @click="priceParam(300)">300€</a>
            <a class="dropdown-item" @click="priceParam(400)">400€</a>
            <a class="dropdown-item" @click="priceParam(500)">500€</a>
            <a class="dropdown-item" @click="priceParam(750)">750€</a>
            <a class="dropdown-item" @click="priceParam(1000)">1000€</a>
          </div>
        </div>
      </div>
    </div>
    <div
      class="column is-tenth-desktop is-tenth-tablet is-tenth-mobile"
    >
      <button class="button button-spacer" v-on:click="clearQuery"><i class="fas fa-times fa-lg spacer"></i>Clear</button>
    </div>
  </div>
</template>

<script>
import { mapGetters, mapState } from 'vuex';

export default {
  name: "SearchOptions",

  data() {
    return {
      bedroomsActive: 0,
      pricesActive: 0,
    };
  },
  computed: {
    ...mapGetters(["getType","getId"]),
    ...mapState({
      type: (state) => `${state.user.type}`
    }),
  },
  mounted() {
    this.paginate();
  },
  methods: {
    clearQuery(){
      var p;

      if(this.type == "landlord")
       p = "/landlord/search"
      else if(this.type == "tenant")
       p = "/tenant"

      this.$router.push({ path: p})
      this.$router.go()
    },
    bedroomParam(b){
      var p;

      if(this.type == "landlord")
       p = "/landlord/search"
      else if(this.type == "tenant")
       p = "/tenant"

      var q = {}

      if(this.$route.query.price)
        q.price = this.$route.query.price

      if(this.$route.query.city)
        q.city = this.$route.query.city

      q.bedrooms = b

      this.$router.push({ path: p, query: q})
      this.$router.go()
    },
    priceParam(b){
      var p;

      if(this.type == "landlord")
       p = "/landlord/search"
      else if(this.type == "tenant")
       p = "/tenant"

      var q = {}

      if(this.$route.query.bedrooms)
        q.bedrooms = this.$route.query.bedrooms

      if(this.$route.query.city)
        q.city = this.$route.query.city
      
      q.price = b

      console.log("query: " + JSON.stringify(q))

      this.$router.push({ path: p, query: q})
      this.$router.go()
    },
    cityParam(){
      var c = document.getElementById("city_input").value;
      var p;

      if(this.type == "landlord")
       p = "/landlord/search"
      else if(this.type == "tenant")
       p = "/tenant"

      var q = {}

      if(this.$route.query.price)
        q.price = this.$route.query.price

      if(this.$route.query.bedrooms)
        q.bedrooms = this.$route.query.bedrooms

      q.city = c

      this.$router.push({ path: p, query: q})
      this.$router.go()
    },
    clickedBedroom() {
      if (this.bedroomsActive === 0) {
        this.bedroomsActive = 1;
      } else {
        this.bedroomsActive = 0;
      }
    },
    clickedPrices() {
      if (this.pricesActive === 0) {
        this.pricesActive = 1;
      } else {
        this.pricesActive = 0;
      }
    },
  },
};
</script>

<style scoped>

.dropdown {
    padding: 0% 6.5% 0% 0%;
}

.spacer {
  margin-right: 5px;
  color: red;
}

.button-spacer {
  width: 60%;
  margin-left: 40%;
}
</style>