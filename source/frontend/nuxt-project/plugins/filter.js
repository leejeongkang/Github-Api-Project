import Vue from "vue";
import moment from 'moment'

Vue.filter('formatDate', (value) => {

  return moment(String(value)).format('YYYY-MM-DD')
})
