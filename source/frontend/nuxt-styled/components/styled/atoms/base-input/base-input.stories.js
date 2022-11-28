import BaseInput from "./base-input.vue";

export default {
  title: 'Styled/Atoms/[PCFC] 입력 인풋',
  components: BaseInput,
  decorators: [
    () => ({
      template:
        '<div style="margin: 1em;"><h2 style="margin-bottom: 20px; font-size: 20px; color: #212121;">(예시) Input Element </h2><div style="display: flex; flex-direction: row; "><story /></div></div>',
    }),
  ],
};

export const Default = () => ({
  components: { BaseInput },
  template:
    `
      <div class="v-group v-group--gap-12">
        <BaseInput class="text-input--lg" placeholder="Input Large"></BaseInput>
        <BaseInput placeholder="Input Default"></BaseInput>
        <BaseInput class="text-input--sm" value="Input Small"></BaseInput>
      </div>
    `
});


