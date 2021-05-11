<template>
  <div class="columns">
    <div
      class="column is-one-third-desktop is-one-third-tablet is-one-third-mobile"
    >
      <div class="field">
        <form v-on:submit.prevent="noop">
        <p class="control has-icons-left">
          <input class="input" id="title_input" type="search" placeholder="Title" :value="title"/>
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
          <input class="input" id="city_input" type="search" placeholder="City" :value="city"/>
          <span class="icon is-small is-left">
            <i class="fas fa-search"></i>
          </span>
        </p>
        </form>
      </div>
    </div>
    <div
      class="column is-tenth-desktop is-tenth-tablet is-tenth-mobile"
    >
      <div class="field">
        <form v-on:submit.prevent="noop">
        <p class="control">
          <input class="input" id="bedroom_input" type="number" min="0" placeholder="Bedrooms" :value="rooms"/>
        </p>
        </form>
      </div>
    </div>
    <div
      class="column is-2-desktop is-2-tablet is-2-mobile"
    >
      <div class="field">
        <form v-on:submit.prevent="noop">
        <p class="control">
          <input class="input" id="price_input" type="number" min="0" placeholder="Price" :value="price"/>
        </p>
        </form>
      </div>
    </div>
    <div
      class="column is-1-desktop is-1-tablet is-1-mobile"
    >
      <button class="button" v-on:click="search"><i class="fas fa-search fa-lg"></i></button>
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
      title: "",
      city: "",
      rooms: "",
      price: "",
    };
  },
  computed: {
    ...mapGetters(["getType","getId"]),
    ...mapState({
      type: (state) => `${state.user.type}`
    }),
  },
  created() {
    if(this.$route.query.title)
      this.title = this.$route.query.title;
    if(this.$route.query.city)
      this.city = this.$route.query.city;
    if(this.$route.query.bedrooms)
      this.rooms = this.$route.query.bedrooms;
    if(this.$route.query.price)
      this.price = this.$route.query.price;
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
    search(){
      var p;

      if(this.type == "landlord")
       p = "/landlord/search"
      else if(this.type == "tenant")
       p = "/tenant"

       var title = document.getElementById("title_input").value;
       var city = document.getElementById("city_input").value;
       var bedrooms = document.getElementById("bedroom_input").value;
       var price = document.getElementById("price_input").value;

        var q = {}

       if(title != "")
        q.title = title
      
       if(city != "")
        q.city = city

       if(bedrooms != "")
        q.bedrooms = bedrooms

       if(price != "")
        q.price = price

        this.$router.push({ path: p, query: q})
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

      if(this.$route.query.title)
        q.title = this.$route.query.title

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
      
      if(this.$route.query.title)
        q.title = this.$route.query.title

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

      if(this.$route.query.title)
        q.title = this.$route.query.title

      q.city = c

      this.$router.push({ path: p, query: q})
      this.$router.go()
    },
    titleParam(){
      var c = document.getElementById("title_input").value;
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

      if(this.$route.query.city)
        q.city = this.$route.query.price

      if(this.$route.query.bedrooms)
        q.bedrooms = this.$route.query.bedrooms

      q.title = c

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
  width: 65%;
  margin-left: 35%;
}
</style>