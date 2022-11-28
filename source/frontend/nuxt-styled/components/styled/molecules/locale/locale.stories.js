import Locale from "./locale.vue";
import { action } from "@storybook/addon-actions";

export default {
  title: 'Styled/Molecules/[PCFI] 언어 선택',
  component: Locale,
  decorators: [
    () => ({
      template:
        '<div style="margin: 1em;"><h2 style="margin-bottom: 20px; font-size: 20px; color: #212121;">(예시) 언어 선택 </h2><div style="display: flex; flex-direction: row; "><story /></div></div>',
    }),
  ],
  parameters: {
    docs: {
      source: {
        code: '<Locale @changeLocale="onChangeLocale"/>',
      },
    },
  },
};

const Template = (args, { argTypes }) => ({
  components: { Locale },
  template: '<Locale @changeLocale="onChangeLocale"/>',
  methods: {
    onChangeLocale(p) {
      action("changeLocale")(p);
    },
  },
});

export const Default = Template.bind({});
