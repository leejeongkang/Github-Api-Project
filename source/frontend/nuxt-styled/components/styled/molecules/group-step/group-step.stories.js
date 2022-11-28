import GroupStep from './group-step.vue';

export default {
  title: 'Styled/Molecules/[PCFI] 단계',
  components: GroupStep,
  decorators: [() => ({ template: '<div style="margin: 1em;"><h2 style="margin-bottom: 40px; font-size: 20px; color: #212121;">(예시) Stepper </h2><story /></div>' })],
};

export const Default = () => ({
  components: { GroupStep },
  template: '<GroupStep stepClass="step__list--detail"></GroupStep>'
});
