<template>
  <div>
    <Picker
      v-model="dateValue"
      :type="type"
      :range="range"
      :format="DATE_FORMAT.DATETIME"
      value-type="format"
      :confirm="confirm"
      :confirm-text="confirmText"
      :disabled="disabled"
      :placeholder="placeholder"
      @change="$emit('change', $event)"
    />
    <p> {{ repo }}</p>
    <button @click="onSubmit({repo, dateValue})">click</button>
  </div>
</template>

<script>
import Picker from "vue2-datepicker";
import "vue2-datepicker/index.css";
import moment from "moment";

export default {
  name: "DatePicker",
  components: {
    Picker
  },
  data() {
    return {
      dateValue: null,
      DATE_FORMAT: {
        DATE: "YYYY-MM-DD",
        DATETIME: "YYYY-MM-DDTHH:MM:SSZ",
        YEAR: "YYYY",
        MONTH: "YYYY-MM",
        TIME: "HH:mm:ss"
      }
    };
  },
  watch: {
    range() {
      this.changeDateFormat();
    }
  },
  props: {
    date: {
      type: String
    },
    startDate: {
      type: String
    },
    endDate: {
      type: String
    },
    format: {
      type: String
    },
    // date |datetime|year|month|time|week
    type: {
      type: String,
      default: "date"
    },
    range: {
      type: Boolean,
      default: false
    },
    confirm: {
      type: Boolean,
      default: true
    },
    confirmText: {
      type: String,
      default: "OK"
    },
    disabled: {
      type: Boolean,
      default: false
    },
    placeholder: {
      type: String
    },
    repo: {
      type: String
    }
  },
  computed: {
    dateFormat() {
      return this.format || this.DATE_FORMAT[this.type.toUpperCase()];
    }
  },
  methods: {
    changeDateFormat() {
      if (this.range) {
        this.dateValue = [moment(this.startDate).format(this.dateFormat), moment(this.endDate).format(this.dateFormat)];
      } else {
        this.dateValue = moment(this.date).format(this.dateFormat);
      }
    },
    async onSubmit({repo, dateValue}) {
      console.log('method' + dateValue + this.repo)
      await this.$store.dispatch('getCommitCntByDate',{repo, dateValue})
      //await this.$store.dispatch('getPrCntByDate', {repo, dateValue})
      this.$emit('update', dateValue)
    }
  },
  mounted() {
    this.changeDateFormat();
  },
  created() {
    // 다국어 처리
    const locale = this.$i18n.locale;
    require(`vue2-datepicker/locale/${locale}`);
  }
};
</script>

<style lang="scss" scoped>
@import "date-picker";
</style>
