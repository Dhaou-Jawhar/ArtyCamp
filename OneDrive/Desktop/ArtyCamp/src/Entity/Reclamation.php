<?php

namespace App\Entity;

use App\Repository\ReclamationRepository;
//use Doctrine\DBAL\Types\Types;
use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Validator\Constraints as Assert;
#[ORM\Entity(repositoryClass: ReclamationRepository::class)]
#[ORM\HasLifecycleCallbacks]
class Reclamation
{
    #[ORM\Id]
    #[ORM\GeneratedValue]
    #[ORM\Column]
    private ?int $idrec = null;

    /*#[ORM\Column(type: Types::DATE_MUTABLE)]
    private ?\DateTimeInterface $Date = null;*/

    #[ORM\Column(type: "text",length: 255)]
    #[Assert\NotBlank(message: "ecrire le message")]
    private ?string $Message = null;

    #[ORM\Column(length: 255)]
    #[Assert\NotBlank(message: "ecrire l'object")]
    #[Assert\Length(
        min: 4,
       // max: 20,
        minMessage: "minimum {{ limit }} caractère ",
       // maxMessage: "Your first name cannot be longer than {{ limit }} characters",
    )]
    private ?string $object = null;

    #[ORM\Column(length: 255)]
    #[Assert\NotBlank(message: "ecrire le Nom")]
    private ?string $Nom = null;

    #[ORM\Column(options:["default"=>"CURRENT_TIMESTAMP"] )]
    private ?\DateTimeImmutable $createAt = null;

    public function getIdrec(): ?int
    {
        return $this->idrec;
    }


    /*public function getDate(): ?\DateTimeInterface
    {
        return $this->Date;
    }

   public function setDate(\DateTimeInterface $Date): self
    {
        $this->Date = $Date;

        return $this;
    }*/

    public function getMessage(): ?string
    {
        return $this->Message;
    }

    public function setMessage(string $Message): self
    {
        $this->Message = $Message;

        return $this;
    }

    public function getObject(): ?string
    {
        return $this->object;
    }

    public function setObject(string $object): self
    {
        $this->object = $object;

        return $this;
    }

    public function getNom(): ?string
    {
        return $this->Nom;
    }

    public function setNom(string $Nom): self
    {
        $this->Nom = $Nom;

        return $this;
    }

    public function getCreateAt(): ?\DateTimeImmutable
    {
        return $this->createAt= new \DateTimeImmutable('now');;
    }

    public function setCreateAt(\DateTimeImmutable $createAt): self
    {
        $this->createAt = $createAt;

        return $this;
    }

}
