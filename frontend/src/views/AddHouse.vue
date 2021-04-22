<template>
  <div>
    <LandlordNavbar />
    <div class="columns is-centered is-vcentered">
        <div class="column is-three-quarters">
            <div class="card" id="form-card">
                <div class="card-content">
                    <p class="title has-text-centered">Add New House</p>
                    <FormulateForm v-model="formData" class="columns is-centered">
                        <div class="column is-one-third">
                            <FormulateInput
                                name="title"
                                label="House Title"
                                type="text"
                                validation="required|max:50,length|min:5,length"
                            />
                            <FormulateInput
                                name="address"
                                label="Address"
                                type="text"
                                validation="required|max:100,length|min:5,length"
                            />
                            <FormulateInput
                                name="bedrooms"
                                label="Number of Bedrooms"
                                type="number"
                                validation="required|number"
                                min="0"
                                max="10"
                            />
                            <FormulateInput
                                name="available"
                                label="Available Bedrooms"
                                type="number"
                                validation="required|number"
                                min="0"
                                max="10"
                            />
                            <FormulateInput
                                name="bathrooms"
                                label="Number of Bathrooms"
                                type="number"
                                validation="required|number"
                                min="0"
                                max="10"
                            />
                            <FormulateInput
                                name="price"
                                label="Price per Bedroom"
                                type="number"
                                validation="required|number"
                                min="0"
                            />
                        </div>
                        <div class="column is-one-third">
                            <FormulateInput
                                type="textarea"
                                name="description"
                                label="Description"
                                validation="required"
                                rows="10"
                            />
                            <FormulateInput
                                type="group"
                                name="features"
                                :repeatable="true"
                                label="Features"
                                add-label="Add Feature"
                                validation="required"
                            >
                                <FormulateInput
                                    name="feature"
                                    type="text"
                                    validation="required"
                                />
                            </FormulateInput>
                        </div>
                        <div class="column is-one-third">
                            <FormulateInput
                                type="image"
                                name="photos"
                                label="Photos"
                                help="Select a png, jpg or gif to upload."
                                validation="required|mime:image/jpeg,image/png,image/gif"
                                multiple
                            />
                            <FormulateInput
                                type="submit"
                                label="Add House"
                            />
                        </div>
                    </FormulateForm>
                </div>
            </div>
        </div>
    </div>
  </div>
</template>

<script>
import LandlordNavbar from '@/components/LandlordNavbar'

export default {
  name: 'Login',
  components: {
    LandlordNavbar
  },
  data() {
    return {
        formData: {}
    };
  },
  computed: {
    
    
  },
  methods: {
    
    
  }
}
</script>


<style scoped>
    #form-card {
        min-height: 80vh;
        margin-top: 2%;
        margin-bottom: 5%;
    }
</style>