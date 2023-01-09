import Highcharts from "./hightcharts";

export default {
  title: "Functional/[PIFC] 하이차트",
  component: Highcharts,
  decorators: [
    () => ({
      template:
        '<div style="margin: 1em;"><h2 style="margin-bottom: 20px; font-size: 20px; color: #212121;">(예시) highcharts </h2><div style="display: flex; flex-direction: row; "><story /></div></div>'
    })
  ],
  args: {
    options: {
      series: [
        {
          data: [1, 2, 3]
        }
      ]
    }
  },
  argTypes: {
    options: {
      type: "object"
    }
  }
};

export const Default = (args, { argTypes }) => {
  return {
    components: { Highcharts },
    template: `<highcharts :options="options" />`,
    computed: {
      options() {
        return args.options;
      }
    },
    methods: {}
  };
};
